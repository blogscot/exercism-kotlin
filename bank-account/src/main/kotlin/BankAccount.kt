import java.lang.IllegalStateException
import java.nio.file.OpenOption

enum class AccountStatus {
  Open,
  Closed
}

class BankAccount {

  var balance = 0
    get() {
      validateAccount()
      return field
    }

  private var status = AccountStatus.Open

  @Synchronized
  fun adjustBalance(amount: Int) {
    validateAccount()
    balance += amount
  }

  fun close() {
    status = AccountStatus.Closed
  }

  private fun validateAccount() {
    if (status == AccountStatus.Closed) throw IllegalStateException()
  }

}