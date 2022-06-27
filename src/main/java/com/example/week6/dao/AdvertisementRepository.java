package com.example.week6.dao;
import com.example.week6.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query(value = "select * from advertisement where user_name like '%?1%' order by created_at desc ", nativeQuery = true)
    List<Advertisement> findAllByUser(String name);

    @Query(value = "select * from advertisement where created_at < ?1 order by created_at desc", nativeQuery = true)
    List<Advertisement> findByCreatedAt(Date date);

    @Query(value = "select * from advertisement where price between ?1 and ?2 order by price asc", nativeQuery = true)
    List<Advertisement> findByPrice(Long min, Long max);

    @Query(value = "select * from advertisement where title like %:text% or detailed_message like %:text% order by created_at desc", nativeQuery = true)
    List<Advertisement> findByTitleOrDetailedMessage(@Param("text") String text);


}
