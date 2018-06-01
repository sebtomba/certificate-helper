import java.security._

import org.bouncycastle.jce.provider.BouncyCastleProvider
object Main {
  def main(args: Array[String]): Unit = {
    Security.insertProviderAt(new BouncyCastleProvider(), 0)
    val cert = CertificateHelper.from("node.certificate.pem")
    println(CertificateHelper.publicAddress(cert).getOrElse(""))
    println()

    val keyPair = CertificateHelper.generateKeyPair()
    val newCert = CertificateHelper.generate(keyPair)
    println(CertificatePrinter.printPrivateKey(keyPair.getPrivate))
    println()
    println(CertificatePrinter.print(newCert))
  }
}
