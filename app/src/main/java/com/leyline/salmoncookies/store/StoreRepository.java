package com.leyline.salmoncookies.store;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class StoreRepository{
    private MutableLiveData<List<Store>> stores = new MutableLiveData<>();
    private LiveData<List<Store>> allStores;
    private final StoreDAO storeDAO;

    public StoreRepository(Application application){
        StoreDatabase db;
        db = StoreDatabase.getInstance(application);
        storeDAO = db.storeDAO();
        allStores = storeDAO.getAllStores();
    }

    private void asyncFinished(List<Store> storeList){
        stores.setValue(storeList);
    }

    public void findStore(String name){
        QueryAsyncTask task = new QueryAsyncTask(storeDAO);
        task.delegate = this;
        task.execute(name);
    }
    private static class QueryAsyncTask extends AsyncTask<String, Void, List<Store>>{
        private StoreDAO asyncTaskDao;
        private StoreRepository delegate = null;
        QueryAsyncTask(StoreDAO dao){
            asyncTaskDao = dao;
        }

        @Override
        protected List<Store> doInBackground(String... strings) {
            return asyncTaskDao.findStore(strings[0]);
        }
        @Override
        protected void onPostExecute(List<Store> result) {
            delegate.asyncFinished(result);
        }
    }
    public void insertStore(Store store){
        InsertAsyncTask task = new InsertAsyncTask(storeDAO);
        task.execute(store);
    }
    ﻿﻿private static class InsertAsyncTask extends AsyncTask<Store, Void, Void> {

        private StoreDAO asyncTaskDao;

        InsertAsyncTask(StoreDAO dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Store... params) {
            asyncTaskDao.addStore(params[0]);
            return null;
        }
    }
    public void deleteStore(String name){
        DeleteAsyncTask task = new DeleteAsyncTask(storeDAO);
        task.execute(name);
    }
    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void>{
        private StoreDAO asyncTaskDao;

        DeleteAsyncTask(StoreDAO dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(String... strings) {
            asyncTaskDao.deleteStore(strings[0]);
            return null;
        }
    }
}
