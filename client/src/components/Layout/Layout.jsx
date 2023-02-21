import { Outlet, useLocation } from 'react-router';

import Headers from './Header/Header';
import Sidebar from './Sidebar/Sidebar';

import styles from './Layout.module.css';
import { useEffect, useState } from 'react';

function Layout() {
  const { pathname } = useLocation();
  const [hasSidebar, setHasSidebar] = useState(true);

  useEffect(() => {
    if (pathname === '/login' || pathname === '/signup') {
      setHasSidebar(false);
    } else {
      setHasSidebar(true);
    }
  }, [pathname]);

  return (
    <>
      <Headers />
      <div
        className={`${styles.container} ${!hasSidebar ? `${styles.gray}` : ``}`}
      >
        {hasSidebar && <Sidebar />}
        <main className={styles.main}>
          <Outlet />
        </main>
      </div>
    </>
  );
}

export default Layout;
