# mysendingbox-java

[![Maven Central](https://img.shields.io/maven-central/v/com.mysendingbox/mysendingbox-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.mysendingbox%22%20AND%20a%3A%22mysendingbox-java%22)

Mysendingbox.fr Java wrapper is a simple but flexible wrapper for the [Mysendingbox.fr](https://www.mysendingbox.fr) API. See full Mysendingbox.fr documentation [here](https://docs.mysendingbox.fr/?java). For best results, be sure that you're using the latest version of the Mysendingbox API and the latest version of the Java wrapper.

## Table of Contents

- [Getting Started](#getting-started)
  - [Registration](#registration)
  - [Installation](#installation)
  - [Letters](#letters)
  - [Accounts](#accounts)
  - [Invoices](#invoices)
- [Example](#example)
- [Testing](#testing)

## Getting Started

Here's a general overview of the Mysendingbox services available, click through to read more.

Please read through the official [API Documentation](https://docs.mysendingbox.fr/?java#) to get a complete sense of what to expect from each endpoint.

### Registration

First, you will need to first create an account at [Mysendingbox.fr](https://www.mysendingbox.fr/signup) and obtain your Test and Live API Keys.

Once you have created an account, you can access your API Keys from the [API keys Panel](https://www.mysendingbox.fr/app/dashboard/settings/keys).

### Installation

Include the following in your `pom.xml` for Maven:

```xml
<dependencies>
  <dependency>
    <groupId>com.mysendingbox</groupId>
    <artifactId>mysendingbox-java</artifactId>
    <version>1.0.3</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.mysendingbox:mysendingbox-java:1.0.3'
```

#### Initialization and Configuration

```java
import com.mysendingbox.Mysendingbox;
import com.mysendingbox.model.Address;
import com.mysendingbox.model.Letter;
import com.mysendingbox.net.MysendingboxResponse;


Mysendingbox.init("yourApiKey");
```

You may optionally set an API version. This is useful for testing your code against new API versions before you upgrade.

```java
import com.mysendingbox.Mysendingbox;
import com.mysendingbox.model.Address;
import com.mysendingbox.model.Letter;
import com.mysendingbox.net.MysendingboxResponse;

Mysendingbox.init("yourApiKey");
```

### Letters

#### Create a new Letter

```java
Mysendingbox.init("YOUR API KEY");

final File file = new File(getClass().getClassLoader().getResource("local_file.pdf").getPath());

MysendingboxResponse<Letter> response = new Letter.RequestBuilder()
    .setTo(
        new Address.RequestBuilder()
            .setName("Mysendingbox")
            .setLine1("25 passage dubail")
            .setCity("Paris")
            .setPostalCode("75010")
            .setCountry("France")
    )
    .setSourceFile(file, "file")
    .setPostageSpeed("D1")
    .setDescription("Sent with the Java Wrapper")
    .setBothSides(false)
    .setPostageType("prioritaire")
    .setColor("bw")
    .setVariables(variables)
    .setPdfMargin(5)
    .create();

Letter letter = response.getResponseBody();

System.out.println(letter);
```

#### Create a new LetterElectronic

```java
Mysendingbox.init("YOUR API KEY");

final File file = new File(getClass().getClassLoader().getResource("local_file.pdf").getPath());

MysendingboxResponse<LetterElectronic> responseElectronic = new LetterElectronic.RequestBuilder()
    .setTo(
        new Address.RequestBuilder()
            .setFirstName("Erlich")
            .setLastName("Dumas")
            .setEmail("mysendingbox@example.com")
            .setStatus("individual")
    )
    .setPostageType("lre")
    .setSourceFile("<h1>Hello from {{website}}</h1>", "html")
    .setDescription("Sent Electronic with the Java Wrapper")
    .setContent("Please review the attached documents:")
    .setVariables(variables)
    .create();

LetterElectronic letterElectronic = responseElectronic.getResponseBody();

System.out.println(letterElectronic);
```

#### Get a specific letter

```java
Mysendingbox.init("YOUR API KEY");

MysendingboxResponse<Letter> response = Letter.retrieve("LETTER_ID");
Letter Letter = response.getResponseBody();

System.out.println(Letter);
```

### Accounts

#### Create a new account for the company

```java
Mysendingbox.init("YOUR API KEY");

MysendingboxResponse<Account> response = new Account.RequestBuilder()
      .setEmail("msb.partner@example.com")
      .setName("Erlich Bachman")
      .setPhone("+33104050607")
      .setCompanyName("MSB Partner from Java Wrapper")
      .setAddressLine1("30 rue de rivoli")
      .setAddressLine2("")
      .setAddressCity("Paris")
      .setAddressCountry("France")
      .setAddressPostalCode("75004")
      .create();

Account account = response.getResponseBody();

System.out.println(response);
```

#### Update the account company email

```java
Mysendingbox.init("YOUR API KEY");

MysendingboxResponse<Account> responseUpdate = new Account.RequestBuilder()
      .setEmail("msb.partner3@example.com")
      .update("ACCOUNT COMPANY ID");

System.out.println(response);
```

### Invoices

#### List all invoices for a company

```java
Mysendingbox.init("YOUR API KEY");

MysendingboxResponse<InvoiceCollection> response = Invoice.list();
InvoiceCollection accounts = response.getResponseBody();

System.out.println(response);
```

#### Retrieve a specific invoice

```java
Mysendingbox.init("YOUR API KEY");

MysendingboxResponse<Invoice> response = Invoice.retrieve("INVOICE ID");
Invoice invoice = response.getResponseBody();

System.out.println(response);
```

## Example

We've provided examples in the `mysendingbox-java-examples/` package that has examples of how to use the mysendingbox-java wrapper with some of our core endpoints.

## Testing

You can run all tests with the command `mvn test` in the main directory.

=======================

Copyright &copy; 2018 Mysendingbox.fr

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
