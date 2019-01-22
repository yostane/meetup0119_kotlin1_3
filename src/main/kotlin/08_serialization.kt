import kotlinx.serialization.*
import kotlinx.serialization.cbor.CBOR
import kotlinx.serialization.json.JSON
import kotlinx.serialization.protobuf.ProtoBuf
import kotlinx.serialization.protobuf.ProtoNumberType
import kotlinx.serialization.protobuf.ProtoType

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")

@Serializable
data class ProtobufData(@SerialId(1) @ProtoType(ProtoNumberType.SIGNED) val a: Int, @SerialId(2) @Optional val b: String = "42")

@UseExperimental(ImplicitReflectionSerializer::class)
fun testJsonSerialization(){
    // serializing objects
    val jsonData = JSON.stringify(Data.serializer(), Data(42))
    val jsonData2 = JSON.stringify(Data(42))
    // serializing lists
    val jsonList = JSON.stringify(Data.serializer().list, listOf(Data(42)))
    println(jsonData) // {"a": 42, "b": "42"}
    println(jsonList) // [{"a": 42, "b": "42"}]

    // parsing data back
    val obj = JSON.parse(Data.serializer(), """{"a":42}""")
    val obj2: Data = JSON.parse("""{"a":42}""")
    println(obj) // Data(a=42, b="42")
}

@UseExperimental(ImplicitReflectionSerializer::class)
fun testCBOR(){
    println("\n--- CBOR ---\n")
    val data = Data(255)
    val dump = CBOR.dump(Data.serializer(), data)
    println(dump.contentToString())

    val dumps = CBOR.dumps(data)
    println(dumps)


}

@UseExperimental(ImplicitReflectionSerializer::class)
fun testProtobufSerialization(){
    println("\n--- PROTOBUF ---\n")
    val protobufData = ProtobufData(15)
    val dumps = ProtoBuf.dumps(ProtobufData.serializer(), protobufData)
    println(dumps)

    val byteArrayDump = ProtoBuf.dump(protobufData)
    println(byteArrayDump.contentToString())

    val data = ProtoBuf.load(ProtobufData.serializer(), byteArrayDump)
    println(data)
}

fun main(args: Array<String>) {
    testJsonSerialization()
    testCBOR()
    testProtobufSerialization()
}