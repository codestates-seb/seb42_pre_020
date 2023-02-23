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
    <div className={`${!hasSidebar ? `${styles.gray}` : ``}`}>
      <Headers />
      <div className={styles.container}>
        {hasSidebar && <Sidebar />}
        <main
          className={`${styles.main} ${
            !hasSidebar ? `${styles.full_width}` : ``
          }`}
        >
          <Outlet />
        </main>
      </div>
    </div>
  );
}

export default Layout;
