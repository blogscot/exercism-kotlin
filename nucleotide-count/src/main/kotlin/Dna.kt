class Dna(strand: String) {
  var nucleotideCounts = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

  init {
    require(strand.all { it in "AGCT" }) { "Invalid argument: $strand" }

    val nucleotides = strand.groupBy { it }.mapValues { it.value.size }

    nucleotideCounts = nucleotides.entries.fold(nucleotideCounts) { acc, (key, value) ->
      acc[key] = value
      acc
    }
  }
}
