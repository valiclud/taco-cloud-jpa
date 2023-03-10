package tacos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Taco {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 
  private String name;
 
  private Date createdAt = new Date();
 
  @ManyToMany()
  @JoinTable(name="Ingredient_Ref")
  private List<Ingredient> ingredients = new ArrayList<>();
  
  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(ingredient);
  }
 
}