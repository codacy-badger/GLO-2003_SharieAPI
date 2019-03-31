package com.github.glo2003.daos;

import com.github.glo2003.exceptions.ItemAlreadyExistsException;
import com.github.glo2003.exceptions.ItemNotFoundException;
import com.github.glo2003.models.Listing;

import java.time.LocalDate;
import java.util.List;

public interface ListingsDAO {
    Listing get(String id) throws ItemNotFoundException;

    List<Listing> getAll();

    List<Listing> getAllWithTitle(String title);

    List<Listing> getAllSpecificDate(LocalDate date);

    String save(Listing listing) throws ItemAlreadyExistsException;

    void reset();

}
