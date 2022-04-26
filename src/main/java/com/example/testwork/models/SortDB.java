package com.example.testwork.models;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;


@Entity
@TypeDefs({
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        ),
})
public class SortDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "int-array")
//    @Type(type = "com.example.testwork.models.IntegerArrayCustomType")
    @Column(
            name = "name",
            columnDefinition = "INT ARRAY")
    private int[] name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int[] getName() {
        return name;
    }

    public void setName(int[] name) {
        this.name = name;
    }

    public SortDB() {
    }

    public SortDB(int[] name) {
        this.name = name;
    }
}
