# PDC backend

## Structure

```txt
cn
  porsche
    smamo
      common
        |__codec // Optional, i.e. Md5Utils, EncodeUtils
        |__constants // Common Constants
        |__converter // Optional
        |__enums // Common Enums
        |__exception // Common Business Exception
        |__factory // Optional
        |__filter // Optional
        |__handler // Optional
        |__utils // Utility or tools
      config // Configuration files
      charging
        |__constants // Business Constants
        |__entity // Enums
        |__enums // Entity
        |__event // Optional, if use Guava Event Bus
        |__exception // Business Exception extends Common Business Exception
        |__repo // DAO or Repository
        |__service // Interface of services
          |__impl // Implementation of services, which is managed by Spring Transaction
        |__web
          |__rest // Rest Controller
            |__assembler // Convert entity to Resource
            |__command // Receive info from Frontend
            |__resource // `Return` info to Frontend
      parking
        |__constants // Business Constants
        |__entity // Enums
        |__enums // Entity
        |__event // Optional, if use Guava Event Bus
        |__exception // Business Exception extends Common Business Exception
        |__repo // DAO or Repository
        |__service // Service Layer, which is managed by Spring Transaction
        |__web
          |__rest // Rest Controller
            |__assembler // Convert entity to Resource
            |__command // Receive info from Frontend
            |__resource // `Return` info to Frontend
```

## Key Stack

1. Spring boot
2. Spring security with SAML
3. Spring HATEOAS
4. AWS related
5. JPA, MySQL and Docker for local development and testing

## Setup Local Development

### Setup Intellij IDEA

1. IDEA需要安装lombok插件

### Local Build

```shell
./gradlew clean build
```

### Local Start

```shell
export SPRING_PROFILES_ACTIVE=local
./gradlew bootRun
```
###MessageCode定义规则
1. 以字母开头+四位数字的形式定义Code
2. 各首字母的意义
  * E：系统异常Code
  * A：账户相关业务Code
  * O：订单相关业务Code
  * P：支付相关业务Code