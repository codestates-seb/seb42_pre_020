import { Outlet } from 'react-router';

import Headers from './Header/Header';
import Sidebar from './Sidebar/Sidebar';

import styles from './Layout.module.css';

function Layout() {
  return (
    <>
      <Headers />
      <div className={styles.container}>
        <Sidebar />
        <main className={styles.main}>
          <Outlet />
        </main>
      </div>
    </>
  );
}

export default Layout;
