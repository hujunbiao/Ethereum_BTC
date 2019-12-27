package com.alsc.net.db.bean;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.alsc.net.db.bean.ETHWallet;
import com.alsc.net.db.bean.IdCradBean;
import com.alsc.net.db.bean.UserInfoBean;
import com.alsc.net.retrofit.download.DownInfo;
import com.alsc.net.retrofit.http.cookie.CookieResulte;
import com.alsc.net.db.bean.BtcWallet;

import com.alsc.net.db.bean.ETHWalletDao;
import com.alsc.net.db.bean.IdCradBeanDao;
import com.alsc.net.db.bean.UserInfoBeanDao;
import com.alsc.net.db.bean.DownInfoDao;
import com.alsc.net.db.bean.CookieResulteDao;
import com.alsc.net.db.bean.BtcWalletDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig eTHWalletDaoConfig;
    private final DaoConfig idCradBeanDaoConfig;
    private final DaoConfig userInfoBeanDaoConfig;
    private final DaoConfig downInfoDaoConfig;
    private final DaoConfig cookieResulteDaoConfig;
    private final DaoConfig btcWalletDaoConfig;

    private final ETHWalletDao eTHWalletDao;
    private final IdCradBeanDao idCradBeanDao;
    private final UserInfoBeanDao userInfoBeanDao;
    private final DownInfoDao downInfoDao;
    private final CookieResulteDao cookieResulteDao;
    private final BtcWalletDao btcWalletDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        eTHWalletDaoConfig = daoConfigMap.get(ETHWalletDao.class).clone();
        eTHWalletDaoConfig.initIdentityScope(type);

        idCradBeanDaoConfig = daoConfigMap.get(IdCradBeanDao.class).clone();
        idCradBeanDaoConfig.initIdentityScope(type);

        userInfoBeanDaoConfig = daoConfigMap.get(UserInfoBeanDao.class).clone();
        userInfoBeanDaoConfig.initIdentityScope(type);

        downInfoDaoConfig = daoConfigMap.get(DownInfoDao.class).clone();
        downInfoDaoConfig.initIdentityScope(type);

        cookieResulteDaoConfig = daoConfigMap.get(CookieResulteDao.class).clone();
        cookieResulteDaoConfig.initIdentityScope(type);

        btcWalletDaoConfig = daoConfigMap.get(BtcWalletDao.class).clone();
        btcWalletDaoConfig.initIdentityScope(type);

        eTHWalletDao = new ETHWalletDao(eTHWalletDaoConfig, this);
        idCradBeanDao = new IdCradBeanDao(idCradBeanDaoConfig, this);
        userInfoBeanDao = new UserInfoBeanDao(userInfoBeanDaoConfig, this);
        downInfoDao = new DownInfoDao(downInfoDaoConfig, this);
        cookieResulteDao = new CookieResulteDao(cookieResulteDaoConfig, this);
        btcWalletDao = new BtcWalletDao(btcWalletDaoConfig, this);

        registerDao(ETHWallet.class, eTHWalletDao);
        registerDao(IdCradBean.class, idCradBeanDao);
        registerDao(UserInfoBean.class, userInfoBeanDao);
        registerDao(DownInfo.class, downInfoDao);
        registerDao(CookieResulte.class, cookieResulteDao);
        registerDao(BtcWallet.class, btcWalletDao);
    }
    
    public void clear() {
        eTHWalletDaoConfig.clearIdentityScope();
        idCradBeanDaoConfig.clearIdentityScope();
        userInfoBeanDaoConfig.clearIdentityScope();
        downInfoDaoConfig.clearIdentityScope();
        cookieResulteDaoConfig.clearIdentityScope();
        btcWalletDaoConfig.clearIdentityScope();
    }

    public ETHWalletDao getETHWalletDao() {
        return eTHWalletDao;
    }

    public IdCradBeanDao getIdCradBeanDao() {
        return idCradBeanDao;
    }

    public UserInfoBeanDao getUserInfoBeanDao() {
        return userInfoBeanDao;
    }

    public DownInfoDao getDownInfoDao() {
        return downInfoDao;
    }

    public CookieResulteDao getCookieResulteDao() {
        return cookieResulteDao;
    }

    public BtcWalletDao getBtcWalletDao() {
        return btcWalletDao;
    }

}
