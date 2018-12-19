enum class AccountStatus {
  Open,
  Closed
}

class BankAccount {

  var balance = 0
    private set
    get() {
      check(status == AccountStatus.Open)
      return field
    }

  private var status = AccountStatus.Open

  fun adjustBalance(amount: Int) {
    check(status == AccountStatus.Open)

    synchronized(this) {
      balance += amount
    }
  }

  fun close() {
    status = AccountStatus.Closed
  }
}
