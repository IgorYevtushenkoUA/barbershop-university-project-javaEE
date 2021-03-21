package kma.javaee.practice7.joinedtable.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "giraffe")
@Getter
@Setter
@NoArgsConstructor
public class GiraffeEntity extends Animal {

    @Column(name = "height")
    private float height;

}
