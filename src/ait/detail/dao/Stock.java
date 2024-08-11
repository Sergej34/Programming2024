package ait.detail.dao;


import ait.detail.model.Detail;

public interface Stock {

    // Create
    boolean addDetail(Detail detail);

    // Read (find)
    Detail findByBarCode(long barCod);

    // Update
    Detail updateDetail(Detail detail);

    // Delete

    Detail deleteDetail(long barCode);

    void printStock();

    int quantity();
}
