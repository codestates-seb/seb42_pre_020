import { useState } from 'react';
import ListItemA from './AboutMe_items/ListItemA';
import ListItemQ from './AboutMe_items/ListItemQ';
import styles from './AboutMe.module.css';

function AboutMe(data) {
  console.log(data.answers);
  const [currentTab, setCurrentTab] = useState(0);
  const menuArr = [{ type: 'Questions' }, { type: 'Answers' }];
  const contentType = menuArr[currentTab].type;

  const selectMenuHandler = (idx) => {
    setCurrentTab(idx);
  };
  return (
    <div className={styles.Tab_Container}>
      <div className={styles.AboutMe_Head}>
        <h2 className={styles.Head_title}>About me</h2>
        <div className={styles.introduction}>hello world!</div>
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
              <ListItemQ />
              <ListItemQ />
              <ListItemQ />
            </>
          ) : (
            <>
              <ListItemA />
              <ListItemA />
              <ListItemA />
            </>
          )}
        </div>
      </div>
    </div>
  );
}

export default AboutMe;
