package com.leyline.salmoncookies.store;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class StoreRepository{
    private final MutableLiveData<List<Store>> storeSearch = new MutableLiveData<>();
    private LiveData<List<Store>> allStores;
    private final StoreDAO storeDAO;

    public StoreRepository(Application application){
        StoreDatabase db = StoreDatabase.getInstance(application);
        storeDAO = db.storeDAO();
        allStores = storeDAO.getAllStores();
    }

    private void asyncFinished(List<Store> storeList){
        storeSearch.setValue(storeList);
    }


//    REPOSITORY API; exposed to UI
    public void insert(Store store){
        new InsertAsyncTask(storeDAO).execute(store);
    }
    public void update(Store store){
        new UpdateAsyncTask(storeDAO).execute(store);
    }
    public void delete(Store store){
        new DeleteAsyncTask(storeDAO).execute(store);
    }
    public void deleteAllStores(){
        new DeleteAllAsyncTask(storeDAO).execute();
    }

    public LiveData<List<Store>> getAllStores() {
        return allStores;
    }
    public MutableLiveData<List<Store>> getStoreSearch(){
        return storeSearch;
    }

//    ASYNC TASKS to move database operations off of the main thread
    //    Static so the task doesn't have a reference to the activity, which would be a memory leak
    // because it is static it cannot reference its parents DAO, dao must be passed into constructor
    private static class InsertAsyncTask extends AsyncTask<Store, Void, Void>{

        private final StoreDAO asyncTaskDao;

        InsertAsyncTask(StoreDAO dao) {
            asyncTaskDao = dao;
        }

        // Store... denotes, var-args; similar to an array
        @Override
        protected Void doInBackground(final Store... params) {
            asyncTaskDao.addStore(params[0]);
            return null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<Store, Void, Void>{

        private final StoreDAO asyncTaskDao;

        UpdateAsyncTask(StoreDAO dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Store... params) {
            asyncTaskDao.updateStore(params[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<Store, Void, Void>{
        private final StoreDAO asyncTaskDao;
        DeleteAsyncTask(StoreDAO dao){
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(Store... params) {
            asyncTaskDao.deleteStore(params[0]);
            return null;
        }
    }
    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void>{
        private final StoreDAO asyncTaskDao;
        DeleteAllAsyncTask(StoreDAO dao){
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAllStores();
            return null;
        }
    }
}
