package ait.detail.dao;


import ait.detail.model.Detail;

public class StockImpl implements Stock {

    private Detail[] details;
    private int size; // сколько деталей

    public StockImpl(int capacity){
        details = new Detail[capacity];
        // this.size = 0;
    }

    @Override
    public boolean addDetail(Detail detail) {
        if (detail == null) {

            return false;
        }
        if (size == details.length) { // or size == capacity
            return false;
        }
        if (findByBarCode(detail.getBarCode()) != null) {
            return false;
        }
        details[size] = detail;
        size++;
        return true;
        }

    @Override
    public Detail findByBarCode(long barCode) {
        for (int i = 0; i < size; i++) {
            if(details[i].getBarCode() == barCode){
                return details[i];
            }
        }
        return null;
    }

    @Override
    public Detail updateDetail(Detail detail) {
        if (detail == null) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == detail.getBarCode()) {
                Detail oldDetail = details[i]; // В массиве имевшего заменяем на того кого на прислали
                details[i] = detail;
                return oldDetail;
            }
        }
        return null;
    }

    @Override
    public Detail deleteDetail(long barCode) {
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == barCode) {
                Detail deletedDetail = details[i];
                // Сдвигаем все элементы влево, чтобы заполнить пустое место
                for (int j = i; j < size - 1; j++) {
                    details[j] = details[j + 1];
                }
                details[size - 1] = null; // Удаляем последний элемент
                size--;
                return deletedDetail;
            }
        }
        return null;
    }

    @Override
    public void printStock() {
        for (int i = 0; i < size; i++) {
            System.out.println(details[i]);
        }

    }

    @Override
    public int quantity() {
        return size;
    }
}
