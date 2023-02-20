import { BiSearch } from 'react-icons/bi';

import Input from '../../UI/Input/Input';
import SubNavList from './SubNav/SubNavList';
import MainNav from './MainNav/MainNav';

import styles from './Header.module.css';

function Header() {
  return (
    <header className={styles.container}>
      <div className={styles.header}>
        {/* LOGO */}
        <a className={styles.logo_container} href="/">
          <span className={styles.logo}>StackOverflow</span>
        </a>
        {/* LIST */}
        <SubNavList text="About" url="/" />
        {/* SEARCH */}
        <form>
          <Input placeholder={'Search...'} isValid leftIcon={<BiSearch />} />
        </form>
        {/* NAV */}
        <MainNav />
      </div>
    </header>
  );
}

export default Header;
