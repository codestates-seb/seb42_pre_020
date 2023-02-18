import { BiSearch } from 'react-icons/bi';

import Input from '../../UI/Input/Input';
import Tags from './Tags/Tags';

import styles from './Sidebar.module.css';

function Sidebar() {
  // 임시 데이터
  const tags = [
    { text: 'react', url: '/' },
    { text: 'javascript', url: '/' },
    { text: 'java', url: '/' },
    { text: 'python', url: '/' },
    { text: 'testing libaray', url: '/' },
    { text: 'node.js', url: '/' },
    { text: 'next.js', url: '/' },
    { text: 'selenium', url: '/' },
    { text: 'django', url: '/' },
    { text: 'C++', url: '/' },
    { text: 'C', url: '/' },
    { text: 'C#', url: '/' },
    { text: '엄청 긴 내용의 태그가 들어간다면 어떻게 처리할껀가요?', url: '/' },
  ];
  return (
    <aside className={styles.sidebar}>
      <header>
        <h3 className={styles.title}>Tags</h3>
        <div className={styles.search}>
          <Input placeholder={'Search...'} isValid leftIcon={<BiSearch />} />
        </div>
      </header>
      <Tags tags={tags} />
    </aside>
  );
}

export default Sidebar;
