package com.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import 	com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.widget.TextView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> petList;
    private RecyclerView recyclerView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.materialToolbar);
        setSupportActionBar(myToolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new  ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(this, agregarFragments()));
        tabLayout.getTabAt(0).setIcon(R.drawable.pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.pata);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_fav:
                Intent intent = new Intent(this, FavoritesActivity.class);
                startActivity(intent);
                return true;
            case R.id.contacto:
                Intent intent2 = new Intent(this, ContactoActivity.class);
                startActivity(intent2);
                return true;
            case R.id.acerca:
                Intent intent3 = new Intent(this, AcercaActivity.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}