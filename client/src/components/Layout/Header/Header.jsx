import { Link } from 'react-router-dom';
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
  const isLogin = true;
  return (
    <header className={styles.container}>
      <div className={styles.header}>
        {/* LOGO */}
        <Link className={styles.logo_container} to="/">
          <span className={styles.logo}>StackOverflow</span>
        </Link>
        {/* LIST */}
        <SubNavList text="About" url="/about" />
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
        <MainNav isLogin={isLogin} />
      </div>
    </header>
  );
}

export default Header;
