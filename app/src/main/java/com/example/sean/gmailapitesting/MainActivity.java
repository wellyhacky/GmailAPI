package com.example.sean.gmailapitesting;

import android.app.PendingIntent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener
{
    private static final int SIGNED_IN  =0;
    private static final int STATE_SIGNING_IN = 1;
    private static final int STATE_IN_PROGRESS = 2;
    private static final int RC_SIGN_IN = 0;

    private GoogleApiClient mGoogleApiClient;
    private int mSigninProgress;
    private PendingIntent mSignInIntent;

    private SignInButton mSignInButton;
    private TextView mStatus;
    private GoogleSignInClient mGoogleSignInClient;
    /*private Button mSignOutButton;
    private Button mRevokeButton;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find textviews
        mSignInButton = (SignInButton) findViewById(R.id.sign_in_button);
        mStatus = (TextView) findViewById(R.id.statuslabel);
        //Build a google api
        GoogleSignInOptions gso = buildGoogleSignInClient();
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
    }
    private GoogleSignInOptions buildGoogleSignInClient(){
        /*return new GoogleApiClient.Builder(this)//builds the api client
                //'this' is referring to the activity
                //root the api to an activity so it knows where to talk to
                .addConnectionCallbacks(this)
                //same as before, where to run stuff if something fails.
                .addOnConnectionFailedListener(this)
                //add the apis to use.
                .addApi(Plus.API,)*/
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
    }
    private void ClickListen(){
        //listen for clicks
        mSignInButton.setOnClickListener(this);
    }
}
