import { BiSearch } from 'react-icons/bi';

import Input from '../../UI/Input/Input';
import SubNavList from './SubNav/SubNavList';
import MainNav from './MainNav/MainNav';

import styles from './Header.module.css';

function Header() {
  const subName = [
    { url: '/', text: 'About' },
    { url: '/', text: 'Products' },
    { url: '/', text: 'For Teams' },
  ];

  return (
    <header className={styles.container}>
      <div className={styles.header}>
        {/* LOGO */}
        <a className={styles.logo_container} href="/">
          <span className={styles.logo}>StackOverflow</span>
        </a>
        {/* LIST */}
        <ul className={`${styles.nav} ${styles['sub_nav']}`}>
          {subName.map((sub) => (
            <SubNavList key={sub.text} {...sub} />
          ))}
        </ul>
        {/* SEARCH */}
        <Input placeholder={'Search...'} isValid leftIcon={<BiSearch />} />
        {/* NAV */}
        <ul className={`${styles.nav} ${styles['main_nav']}`}>
          <MainNav isLogin />
        </ul>
      </div>
    </header>
  );
}

export default Header;
