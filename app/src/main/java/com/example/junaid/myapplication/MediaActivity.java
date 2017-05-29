package com.example.junaid.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MediaActivity extends AppCompatActivity {
    Button btngallery,btnmusic,btnvideo;
    ImageView imageView;
    private static final int PICK_IMAGE = 100;
    private static final int PICK_Audio = 10;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        imageView = (ImageView) findViewById(R.id.imageView);
        btngallery = (Button) findViewById(R.id.btngallery);
        btnmusic = (Button) findViewById(R.id.btnmusic);
        btnvideo = (Button) findViewById(R.id.btnvideo);

        btngallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        btnmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMusic();
            }
        });
    }
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);

    }
      private void openMusic(){
           Intent music = new Intent (Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
           startActivityForResult(music,PICK_Audio);
       }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((resultCode == RESULT_OK && requestCode == PICK_IMAGE)) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        } else if (resultCode == RESULT_OK && requestCode == PICK_Audio) {
            Uri uriSound = data.getData();
            play(this, uriSound);
        }
    }

    private void play(Context context, Uri uri) {
        try
        {
            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource(context,uri);
            mp.start();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        catch (SecurityException e){
          e.printStackTrace();
    }
    catch (IllegalStateException e){
        e.printStackTrace();
    }
    catch (IOException e){
        e.printStackTrace();
    }
    }
}
