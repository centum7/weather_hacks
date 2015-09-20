package jp.co.aizu_student.weatherhacks.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import jp.co.aizu_student.weatherhacks.R;
import jp.co.aizu_student.weatherhacks.fragments.MainFragment;


public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ====Toolbar(Actionbar)を初期化==== */
        // ToolbarをLayoutファイルから取得

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);

        // Toolbarのタイトルを設定

        toolbar.setTitle(R.string.app_name);

        // Toolbarのタイトル文字色を設定

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        // ToolbarをSupportActionBarに設定

        setSupportActionBar(toolbar);

        /* ===================================== */


        /* =========タブレイアウトを初期化========= */
        // TabLayoutをLayoutファイルから取得
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        // ViewPagerをLayoutファイルから取得

            ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);


        // MyPagerAdapterを生成

        MyPagerAdapter adapter = new MyPagerAdapter(this);

        // ViewPagerにMyPagerAdapterを設定

        viewPager.setAdapter(adapter);

        // ViewPagerに「ページが切り替わった時」のListenerを設定

//        viewPager.addOnPageChangeListener(new ViewPager);

        // TabLayoutにViewPagerを設定

        tabLayout.setupWithViewPager(viewPager);

        // TabLayoutのTabをいい感じに表示させるための設定(2行)

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        /* ===================================== */
    }

    /**
     * ページャのアダプタークラス
     */
    private class MyPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
        private AppCompatActivity mActivity;

        public MyPagerAdapter(AppCompatActivity activity) {
            super(activity.getSupportFragmentManager());
            mActivity = activity;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public Fragment getItem(final int position) {
            /* ===表示するFragmentを生成＆返却=== */
            // Bundleを生成

            Bundle bundle = new Bundle();

            // BundleにFragment生成時に必要な値を設定(今日or明日)

            bundle.putInt("targetDay",position);

            // Fragmentを生成

            MainFragment mainFragment = new MainFragment();

            // FragmentにBundleを設定

            mainFragment.setArguments(bundle);

            // Fragmentを返却
            return mainFragment;

            /* =============================== */
        }

        @Override
        public int getCount() {
            // タブの表示個数を返却
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // タブに表示されるタイトルを返却
            if (position == 0) {
                return   mActivity.getString(R.string.today);
            } else {
                return mActivity.getString(R.string.tomorrow);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            for (Fragment f : getSupportFragmentManager().getFragments()) {
                // FragmentをMainFragmentにキャスト

                // Fragmentにあるリクエスト関数を呼び出す

            }

            // Snackbarで更新したことを知らせる

        }
        return super.onOptionsItemSelected(item);
    }
}
