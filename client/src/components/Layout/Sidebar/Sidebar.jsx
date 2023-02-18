import { BiSearch } from 'react-icons/bi';

import Tag from '../../UI/Tag/Tag';
import Input from '../../UI/Input/Input';

import styles from './Sidebar.module.css';
import Tags from './Tags/Tags';

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
