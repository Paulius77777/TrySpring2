package com.example.Zenitech;

import java.util.List;

import com.example.Zenitech.Owner;
import org.springframework.data.repository.CrudRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface OwnerRepository extends CrudRepository<Owner, Long> {


    Owner findByIsbn(String isbn);

    List<Owner> findByOwnerContaining(String owner);
}
