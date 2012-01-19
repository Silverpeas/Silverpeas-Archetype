#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model;

import javax.persistence.*;


//@Entity
//@Table(name = "sc_${rootArtifactId}_myentity")
public class MyEntity {
    @Id
    @SequenceGenerator(name = "sc_${rootArtifactId}_myentity_id_seq", sequenceName = "sc_${rootArtifactId}_myentity_id_seq")
    @GeneratedValue(generator = "sc_${rootArtifactId}_myentity_id_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @SuppressWarnings("unused") // only used for persistence
    @Column
    private String componentId;

    @SuppressWarnings("unused") // only used for persistence
    private MyEntity() {}

    public MyEntity(String firstName, String lastName, String componentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.componentId = componentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public Integer getId() {
		return id;
	}
}
