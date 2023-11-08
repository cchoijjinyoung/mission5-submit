# mission5-submit

## Error
* LogAspect.class => loggingAspect() 의 result값에 null이 들어감.
  * serviceImpl의 메서드의 리턴이 void이기 때문
  * 리턴값을 주는 방법 선택.

* repository => getEntity() : null일 때 에러 처리.
  * runCaching.getOrElse(throw)


## 암복호화
* Entity의 컬럼에 @Encrypt 커스텀 어노테이션을 붙임.
* reponsitory의 save, find로 시작하는 메서드를 pointCut으로 잡고 저장 전 암호화
  