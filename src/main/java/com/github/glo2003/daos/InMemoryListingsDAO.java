package com.github.glo2003.daos;

import com.github.glo2003.exceptions.ItemAlreadyExistsException;
import com.github.glo2003.exceptions.ItemNotFoundException;
import com.github.glo2003.helpers.MathHelper;
import com.github.glo2003.models.Listing;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryListingsDAO implements ListingsDAO {
    private Map<Long, Listing> listings = new HashMap<>();

    @Override
    public Listing get(long id) throws ItemNotFoundException {
        Listing listing = listings.get(id);
        if (listing == null) {
            throw new ItemNotFoundException(String.format("No listing with id '%d' was found", id));
        }
        return listing;
    }

    @Override
    public List<Listing> getAll() {
        return new ArrayList<>(listings.values());
    }

    @Override
    public List<Listing> getAllWithName(String name) {
        ArrayList<Listing> listOfListings = new ArrayList<>();
        listings.forEach((k, v) -> {
            if(name.equals(v.getTitle())) {
                listOfListings.add(listings.get(k));
            }
        });
        return listOfListings;
    }
    
    public List<Listing> getAllSpecificDate(LocalDate date) {
        List<Listing> filteredListings = new ArrayList<>();
        for (Listing listing: listings.values()) {
            for (Instant availability:listing.getAvailabilities()) {
                if(availability.atZone(ZoneOffset.systemDefault()).getYear() == date.getYear()
                        && availability.atZone(ZoneOffset.systemDefault()).getMonthValue() == date.getMonthValue()
                        && availability.atZone(ZoneOffset.systemDefault()).getDayOfMonth() == date.getDayOfMonth()){
                    filteredListings.add(listing);
                }
            }
        }
        return filteredListings;
    }

    @Override
    public long save(Listing listing) throws ItemAlreadyExistsException {
        if (listings.containsValue(listing)) {
            throw new ItemAlreadyExistsException("The listing already exists");
        }

        long id = MathHelper.randomLong();
        while (listings.containsKey(id)) {
            id = MathHelper.randomLong();
        }
        listings.put(id, listing);
        return id;
    }
}
