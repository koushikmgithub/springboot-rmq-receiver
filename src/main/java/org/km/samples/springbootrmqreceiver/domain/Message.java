package org.km.samples.springbootrmqreceiver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor

public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }
}

