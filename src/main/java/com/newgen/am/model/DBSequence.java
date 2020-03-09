/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author nhungtt
 */
@Document(collection = "database_sequences")
public class DBSequence {

    @Id
    private ObjectId id;

    public long seq;

    public DBSequence(long seq) {
        this.seq = seq;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public ObjectId getId() {
        return id;
    }

    public long getSeq() {
        return seq;
    }

}
