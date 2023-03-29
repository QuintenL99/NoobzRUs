package com.example.noobzrus.repositories;

import com.example.noobzrus.models.Tournaments;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TournamentsRepository extends CrudRepository<Tournaments, Integer> {

}
