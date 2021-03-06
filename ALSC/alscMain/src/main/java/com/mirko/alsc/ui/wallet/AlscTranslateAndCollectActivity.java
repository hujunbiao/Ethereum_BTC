package com.mirko.alsc.ui.wallet;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alsc.utils.base.AlscBaseActivity;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.mirko.alsc.R;
import com.mirko.alsc.adapter.AlasTransferAndCollectAdapter;
import com.mirko.alsc.bean.AlscCurrentData;
import com.mirko.alsc.bean.CurrencyData;
import com.mirko.alsc.constant.Constants;
import com.mirko.alsc.databinding.ActivityAlscTransferAndCollectBinding;
import com.mirko.alsc.ui.entity.TabWalletEntity;
import com.mirko.androidutil.utils.android.LogUtils;
import com.mirko.androidutil.utils.android.ToastUtils;
import com.mirko.androidutil.view.statusbar.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by WuQuan on 2019/12/29.
 * 币种详细页面
 */
public class AlscTranslateAndCollectActivity extends AlscBaseActivity implements View.OnClickListener {


    private static final String TAG = "AlscTranslateAndCollectActivity";
    ActivityAlscTransferAndCollectBinding binding;
    private List<AlscCurrentData> currencyDatas;
    private AlasTransferAndCollectAdapter adapter;
    private String btcAddress,btcPrivateKey,address;
    private int mTitleIds[] = new int[]{
            R.string.capital_transfer,
            R.string.capital_receiveables,
            R.string.capital_all,
            R.string.capital_exchange
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alsc_transfer_and_collect);
        binding.commonHeader.ivHeaderLeft.setOnClickListener(this);
        binding.llTransfer.setOnClickListener(this);
        binding.llReceivables.setOnClickListener(this);

        Intent intent = getIntent();
        btcAddress=intent.getStringExtra(Constants.btcAddress);
        btcPrivateKey=intent.getStringExtra(Constants.btcPrivateKey);
        address=intent.getStringExtra(Constants.walletAddress);
        binding.address.setText(address);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        binding.commonHeader.ivHeaderLeft.setOnClickListener(this);
        binding.commonHeader.tvHeaderMiddle.setText(getString(R.string.total_assets_alsc));

        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitleIds.length; i++) {
            mTabEntities.add(new TabWalletEntity(getString(mTitleIds[i])));
        }
        binding.ctCapitalTitle.setTabData(mTabEntities);

        currencyDatas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            AlscCurrentData currencyData = new AlscCurrentData();
            currencyData.setName("BTC");
            currencyDatas.add(currencyData);
        }
        adapter = new AlasTransferAndCollectAdapter(R.layout.list_tranfer_and_collect_detail, currencyDatas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(AlscTranslateAndCollectActivity.this);
        binding.rvCurrencyDetail.setLayoutManager(layoutManager);
        binding.rvCurrencyDetail.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(((adapter1, view, position) -> {
            switch (position) {
                case 0:
                    goTo(ETHSymbolDetailActivity.class);
                    break;
            }
        }));
        binding.ctCapitalTitle.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColorNoTranslucent(AlscTranslateAndCollectActivity.this, getResources().getColor(R.color.color_slide_bg));
    }

    @Override
    public void initAttrs() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_left:
                LogUtils.d(TAG, "返回点击");
                onBackPressed();
                break;
            case R.id.ll_transfer:
                goTo(ETHTransferActivity.class);
                break;
            case R.id.ll_receivables:
                goTo(ETHCollectActivity.class);
                break;
            case R.id.iv_header_left:
                onBackPressed();
                break;
        }
    }
}
