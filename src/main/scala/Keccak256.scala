import org.bouncycastle.crypto.digests.KeccakDigest

object Keccak256 {

  def hash(input: Array[Byte]): Array[Byte] = {
    val digestFn = new KeccakDigest(256)
    digestFn.update(input, 0, input.length)
    val res = new Array[Byte](32)
    digestFn.doFinal(res, 0)
    res
  }

}
