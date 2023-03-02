import { useState } from 'react';

import ListItemA from './AboutMe_items/ListItemA';
import ListItemQ from './AboutMe_items/ListItemQ';

import styles from './AboutMe.module.css';

// 임의의 데이터
const users = {
  name: `One-Punch Man`,
  profileimage:
    'https://images.unsplash.com/photo-1473830394358-91588751b241?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80',
  detail: 'Hello World!',
};
const question = [
  {
    id: 111,
    user_id: 111111,
    title: '호랑이랑 사자랑 싸우면 누가 이기나요?',
    tags: ['동물', '맹수', '호랑이', '사자', '싸움순위'],
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
  {
    id: 222,
    user_id: 222222,
    title: '라면 맛있게 끓이는 방법 좀 가르쳐 주세요.',
    tags: ['전 세계에서', '4번째', '정도', '맛있는', '라면', '라끼남'],
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
  {
    id: 333,
    user_id: 333333,
    title: '오팬무?',
    tags: ['오늘', '빤쮸', '무슨색?'],
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
  {
    id: 444,
    user_id: 444444,
    title: '햄버거 최대 몇개 드시나요?',
    tags: ['푸파', '푸드파이터', '먹방', '햄최몇'],
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
];
const answer = [
  {
    id: 111,
    q_id: 111111,
    detail: '사자던 호랑이던 내가 다이김! 암튼 그럼 ㅇㅇ',
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
  {
    id: 222,
    q_id: 222222,
    detail: '다 때려박고 3분간 팔팔 끓이세요.',
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
  {
    id: 333,
    q_id: 333333,
    detail: '무지개색',
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
  {
    id: 444,
    q_id: 444444,
    detail: '9와 4분의 3개',
    create_dt: 'Fri Feb 24 2023 22:19:26 GMT+0900 (한국 표준시)',
  },
];
//

function AboutMe() {
  const [currentTab, setCurrentTab] = useState(0);
  const menuArr = [{ type: 'Questions' }, { type: 'Answers' }];
  const contentType = menuArr[currentTab].type;

  const [questions, setQuestions] = useState(question);
  const [answers, setAnswers] = useState(answer);

  const selectMenuHandler = (idx) => {
    setCurrentTab(idx);
  };
  return (
    <div className={styles.Tab_Container}>
      <div className={styles.AboutMe_Head}>
        <h2 className={styles.Head_title}>About me</h2>
        <div className={styles.introduction}>{users.detail}</div>
      </div>
      <ul className={styles.Tab_Menu}>
        {menuArr.map((tab, idx) => {
          return (
            <li
              role="presentation"
              className={
                currentTab === idx
                  ? `${styles.Submenu} ${styles.focused}`
                  : styles.Submenu
              }
              key={idx}
              onClick={() => selectMenuHandler(idx)}
            >
              {tab.type}
            </li>
          );
        })}
      </ul>
      <div className={styles.List_container}>
        <div>
          {contentType === 'Questions' ? (
            <>
              {questions &&
                questions.map((item) => (
                  <ListItemQ
                    key={item.id}
                    questions={questions}
                    setQuestions={setQuestions}
                  />
                ))}
            </>
          ) : (
            <>
              {questions &&
                questions.map((item) => (
                  <ListItemA
                    key={item.id}
                    answers={answers}
                    setAnswers={setAnswers}
                  />
                ))}
            </>
          )}
        </div>
      </div>
    </div>
  );
}

export default AboutMe;
