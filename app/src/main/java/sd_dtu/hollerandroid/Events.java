package sd_dtu.hollerandroid;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Events extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    NoticeViewPager viewPagerAdapter;
    boolean isfull = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/OpenSans-Regular.ttf", true);
        tabLayout = (TabLayout)findViewById(R.id.tab1_layout);
        viewPager = (ViewPager)findViewById(R.id.event_pager);
        viewPagerAdapter = new NoticeViewPager(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new AllCollege(),"ALL");
        viewPagerAdapter.addFragments(new MyCollege(),"MY COLLEGE");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.event_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.starr:
            {
                if(isfull)
                {
                    item.setIcon(R.drawable.starborder);
                    isfull=false;
                }
                else
                {
                    isfull=true;
                    item.setIcon(R.drawable.star);
                    Toast.makeText(getApplicationContext(), "Starred", Toast.LENGTH_LONG).show();
                }
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
