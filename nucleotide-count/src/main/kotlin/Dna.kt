class Dna(strand: String) {
  var nucleotideCounts = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

  init {
    nucleotideCounts = strand.fold(nucleotideCounts) { acc, nucleotide ->

      when (nucleotide) {
        !in "AGCT" ->
          throw IllegalArgumentException("Invalid nucleotide: $nucleotide")
        in nucleotideCounts -> acc[nucleotide] = acc[nucleotide]!! + 1
        else -> acc[nucleotide] = 1
      }
      acc
    }
  }
}
