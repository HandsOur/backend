# backend

## Getting Started

clone 후 레포마다 한 번 실행해주세요. 커밋 전에 `ktlintCheck` 가 자동으로 실행되고, 위반이 있으면 커밋이 중단됩니다.

```shell
make init
```

위반은 아래 명령어로 수정할 수 있습니다. 자동으로 고칠 수 없는 항목은 직접 수정해주세요.

```shell
./gradlew ktlintFormat
```
