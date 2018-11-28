enum class Allergen(val score: Int) {
  EGGS(1),
  PEANUTS(2),
  SHELLFISH(4),
  STRAWBERRIES(8),
  TOMATOES(16),
  CHOCOLATE(32),
  POLLEN(64),
  CATS(128)
}

class Allergies(private val score: Int) {

  fun isAllergicTo(allergen: Allergen) =
      allergen.score and score == allergen.score


  fun getList() =
      Allergen.values()
          .filter { (it.score and score) == it.score }

}