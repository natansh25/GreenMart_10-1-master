package infinity1087.android.com.examplehr.loginFragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.List;

import infinity1087.android.com.examplehr.Client.ExClient;
import infinity1087.android.com.examplehr.MainActivity;
import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.Services.ApiClient;
import infinity1087.android.com.examplehr.Services.ApiInterface;
import infinity1087.android.com.examplehr.model.SwaggerPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment implements Validator.ValidationListener {


    Button signUp;
    protected Validator validator;
    protected boolean validated;
    public static String signup_name, signup_lastname;
    public static String signup_email;


    @NotEmpty(message = "Field should not be left blank !!")
    EditText edt_fname;
    @NotEmpty(message = "Field should not be left blank !!")
    EditText edt_lname;
    @NotEmpty(message = "Field should not be left blank !!")
    @Password(scheme = Password.Scheme.ALPHA_NUMERIC, message = "Please enter an ALPHA_NUMERIC password for better security !!")
    @Length(min = 7, message = "Password should be minimum of 7 characters !!")
    EditText edt_password;

    @ConfirmPassword
    EditText edtConfPass;

    @NotEmpty(message = "Field should not be left blank !!")
    @Length(max = 10, min = 10, message = "Input must be between 0 to 10")
    @Pattern(regex = "[0-9]+", message = "Can contain only digits from 0 to 9 !!")
    EditText edt_phone;
    @NotEmpty(message = "Field should not be empty !!")
    @Email
    EditText edt_email;

    public SignUp() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        validator = new Validator(this);
        validator.setValidationListener(this);
        edt_fname = view.findViewById(R.id.edt_fname);
        edt_lname = view.findViewById(R.id.edt_lname);
        edt_password = view.findViewById(R.id.edt_signUp_password);
        edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edtConfPass = view.findViewById(R.id.edtConfPass);
        edtConfPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

        edt_email = view.findViewById(R.id.edt_email2);

        initViews(view);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validator.validate();

                String name1 = edt_fname.getText().toString().trim();
                String lastn1 = edt_lname.getText().toString().trim();
                String pass1 = edt_password.getText().toString().trim();
                signup_lastname = lastn1;
                signup_name=name1;
                signup_email=edt_email.getText().toString();

                ApiInterface apiInterface = ApiClient.getApiClient(ApiClient.Swagger_url).create(ApiInterface.class);
                apiInterface.signUp(name1, lastn1, signup_email).enqueue
                        (new Callback<SwaggerPost>() {
                            @Override
                            public void onResponse(Call<SwaggerPost> call, Response<SwaggerPost> response) {
                                if (response.isSuccessful()) {

                                    // showResponse(response.body().toString());
                                    Log.d("121212", "post submitted to API." + response.body().toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<SwaggerPost> call, Throwable t) {
                                Log.d("121212", "Unable to submit post to API." + t.getMessage());
                            }
                        });

                // Intent i = new Intent(getActivity(), MainActivity.class);
                //  startActivity(i);
                validator.validate();
            }
        });


        return view;
    }


    protected boolean validate() {

        if (validator != null)
            validator.validate();
        return validated;           // would be set in one of the callbacks below

    }


    private void addValidationToViews(View view) {


    }

    private void initViews(View view) {

        edt_fname = view.findViewById(R.id.edt_fname);
        edt_lname = view.findViewById(R.id.edt_lname);
        edt_phone = view.findViewById(R.id.edt_phone);
        edt_password = view.findViewById(R.id.edt_signUp_password);
        edtConfPass = view.findViewById(R.id.edtConfPass);

        signUp = view.findViewById(R.id.btn_signUp);


        addValidationToViews(view);
    }


    @Override
    public void onValidationSucceeded() {

        validated = true;
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        validated = false;

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getActivity());

            // Display error messages

            if (view instanceof EditText) {
                edt_fname = (EditText) view;
                edt_fname.setError(message);
            }
            if (view instanceof EditText) {
                edt_lname = (EditText) view;
                edt_lname.setError(message);
            }
            if (view instanceof EditText) {
                edt_phone = (EditText) view;
                edt_phone.setError(message);
            }
            if (view instanceof EditText) {
                edt_password = (EditText) view;
                edt_password.setError(message);
            }
            if (view instanceof EditText) {
                edt_email = (EditText) view;
                edt_email.setError(message);
            }
            if (view instanceof EditText) {
                edtConfPass = (EditText) view;
                edtConfPass.setError(message);
            }

        }

    }
}


