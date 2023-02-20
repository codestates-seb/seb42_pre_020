import { useState } from 'react';
import { BiSearch } from 'react-icons/bi';

import Input from '../../UI/Input/Input';
import SubNavList from './SubNav/SubNavList';
import MainNav from './MainNav/MainNav';

import styles from './Header.module.css';

function Header() {
  const [query, setQuery] = useState('');

  const onChangeHandler = (e) => {
    setQuery(e.target.value);
  };

  const onSubmitHandler = (e) => {
    console.log('검색');
    e.preventDefault();
  };

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
        <form onSubmit={onSubmitHandler}>
          <Input
            placeholder={'Search...'}
            isValid
            value={query}
            leftIcon={<BiSearch />}
            onChange={onChangeHandler}
          />
        </form>
        {/* NAV */}
        <MainNav />
      </div>
    </header>
  );
}

export default Header;
