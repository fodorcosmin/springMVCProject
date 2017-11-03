package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Stock;
import ro.sci.restaurant.repository.StockRepository;

import java.util.List;

//import ro.sci.restaurant.domain.Stock;

/**
 * Created by cosmin on 9/25/17.
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock findByUid(int id) {
        return stockRepository.findByUid(id);
    }

    public List getAll() {
        return stockRepository.findAll();
    }

    public void update(Stock stock) {

        stockRepository.save(stock);
    }

    public void add(Stock stock) {
        if (stockRepository.findAllByItem(stock.getItem()).isEmpty()) {
            stockRepository.save(stock);
        } else {
            for (Stock stockFound : stockRepository.findAll()) {
                if (stockFound.getItem().equals(stock.getItem())) {
                    stockFound.setQuantity(stockFound.getQuantity() + stock.getQuantity());
                    stockRepository.findByUid(stockFound.getUid()).setQuantity(stockFound.getQuantity() - stock.getQuantity());
                    break;
                }
            }
        }
    }

    public void remove(Stock stock) {
        for (Stock stockFound : stockRepository.findAll()) //TODO
        {
            if (stockFound.getItem().equals(stock.getItem())) {
                stockFound.setQuantity(stockFound.getQuantity() - stock.getQuantity());
                stockRepository.findByUid(stockFound.getUid()).setQuantity(stockFound.getQuantity() - stock.getQuantity());
                if (stockFound.getQuantity() <= 0) {
                    stockRepository.delete(stockFound.getUid()); //todo
                }
                break;
            }
        }
    }

    public void delete(int id) {
        stockRepository.delete(id);
    }

}
