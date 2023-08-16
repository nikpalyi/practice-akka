import sbt.*

object Dependency {

  val akkaVersion = "2.6.21"
  val akkaHttpVersion = "10.2.9"
  val AkkaManagementVersion = "1.1.4"

  val log4jVersion = "2.14.1"
  val rabbitClientVersion = "5.11.0"
  val slapiVersion = "3.0.2"
  val dmpProtoVersion = "2.0.7"
  val serializersVersion = "1.1.86"
  val protoVersion = "3.11.4"
  val scalaVersion = "2.13"

  lazy val allTestScope: String = "test, it, fun"

  lazy val akka = Seq(
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-discovery" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % allTestScope,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % allTestScope,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % allTestScope,
    "com.lightbend.akka.management" %% "akka-management" % AkkaManagementVersion,
    "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % AkkaManagementVersion,
    "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaManagementVersion,
    "com.lightbend.akka.discovery" %% "akka-discovery-kubernetes-api" % AkkaManagementVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % allTestScope,
    "com.typesafe.akka" %% "akka-cluster-sharding-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-discovery" % akkaVersion % allTestScope,
    "com.typesafe.akka" %% "akka-discovery" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence-query" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence-testkit" % akkaVersion % allTestScope
  )

  lazy val akkaStreamAlpakka: Seq[ModuleID] = Seq(
    "com.lightbend.akka" %% "akka-stream-alpakka-amqp" % "3.0.2",
    "com.typesafe.akka" %% "akka-stream-kafka" % "2.1.0",
    "com.typesafe.akka" %% "akka-stream-kafka-testkit" % "2.1.0" % allTestScope,
    "io.github.embeddedkafka" %% "embedded-kafka" % "3.5.0" % "it"
  )

  lazy val akkaPersistenceCassandra: Seq[ModuleID] = Seq(
    "com.typesafe.akka" %% "akka-persistence-cassandra" % "1.0.6"
  )

  lazy val scalatest = Seq(
    "org.scalatest" %% "scalatest" % "3.2.12" % allTestScope,
    ("org.scalatest" %% "scalatest" % "3.2.12" % "test->*").excludeAll(ExclusionRule(organization = "org.junit", name = "junit"))
  )

  lazy val scalaCheck: Seq[ModuleID] = Seq(
    "org.scalacheck" %% "scalacheck" % "1.17.0" % allTestScope
  )

  lazy val mockito: Seq[ModuleID] = Seq(
    "org.mockito" %% "mockito-scala" % "1.14.0" % allTestScope
  )

  lazy val logging = Seq(
    "ch.qos.logback" % "logback-classic" % "1.2.11" % Runtime,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
  )

  lazy val cats = Seq(
    "org.typelevel" %% "cats-effect" % "3.3.12"
  )

  lazy val observability: Seq[ModuleID] = Seq(
    "io.micrometer" % "micrometer-registry-prometheus" % "1.9.0",
    "io.github.mweirauch" % "micrometer-jvm-extras" % "0.2.2",
    "io.prometheus" % "simpleclient_httpserver" % "0.15.0",
    "io.opentracing" % "opentracing-api" % "0.33.0"
  )

  lazy val rabbitClient: Seq[ModuleID] = Seq(
    "com.rabbitmq" % "amqp-client" % rabbitClientVersion
  )

  lazy val dbTestContainers: Seq[ModuleID] = Seq(
    "com.dimafeng" %% "testcontainers-scala-scalatest" % "0.40.12" % "it",
    "com.dimafeng" %% "testcontainers-scala-rabbitmq" % "0.40.12" % "it"
  )

  lazy val proto: Seq[ModuleID] = Seq(
    "com.google.protobuf" % "protobuf-java" % protoVersion % "protobuf",
    "com.google.protobuf" % "protobuf-java" % protoVersion,
    ("com.google.protobuf" % "protobuf-java-util" % protoVersion).exclude("com.google.errorprone", "error_prone_annotations"),
    "com.ppb.eventstate" %% "slapi-proto" % slapiVersion,
    "com.ppb.eventstate" %% "slapi-proto" % slapiVersion % "protobuf",
    ("com.ppb.eventstate" %% "slapi-serializers" % slapiVersion).exclude("org.typelevel", s"cats-effect_$scalaVersion"),
    ("com.ppb.eventstate" %% "slapi-serializers" % slapiVersion % allTestScope).exclude("org.typelevel", s"cats-effect_$scalaVersion"),
    ("com.ppb.dm" % "dmp-core-lib-api-proto" % dmpProtoVersion).exclude("org.apache.kafka", s"kafka_$scalaVersion"),
    ("com.ppb.dm" % "dmp-core-lib-api-proto" % dmpProtoVersion % "protobuf").exclude("org.apache.kafka", s"kafka_$scalaVersion")
  )

  lazy val monocle = Seq(
    "dev.optics" %% "monocle-macro" % "3.2.0"
  )

  lazy val scalatestPlus: Seq[ModuleID] = Seq(
    "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0" % allTestScope,
    "org.scalatestplus" %% "mockito-1-10" % "3.1.0.0" % allTestScope
  )

  lazy val coreDeps: Seq[ModuleID] =
    akka ++ scalatest ++ scalaCheck ++ scalatestPlus ++ logging ++ observability ++ cats ++ rabbitClient ++ akkaStreamAlpakka ++ mockito ++ monocle ++ proto ++ akkaPersistenceCassandra
}
