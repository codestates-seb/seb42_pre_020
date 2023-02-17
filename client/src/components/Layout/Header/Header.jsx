import { BiSearch } from 'react-icons/bi';
import Input from '../../UI/Input/Input';
import Button from '../../UI/Button/Button';
import styles from './Header.module.css';

function Header() {
  return (
    <header>
      {/* LOGO */}
      <a href="/">StackOverflow</a>
      {/* LIST */}
      <ul>
        <li>
          <a href="/">About</a>
        </li>
        <li>
          <a href="/">Products</a>
        </li>
      </ul>
      {/* SEARCH */}
      <Input placeholder={'Search...'} isValid leftIcon={<BiSearch />} />
      {/* NAV */}
      <ul>
        <li>
          <Button text="Log In" size="small" color="border" />
        </li>
        <li>
          <Button text="Sign up" size="small" />
        </li>
      </ul>
    </header>
  );
}

export default Header;
