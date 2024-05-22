import Image from 'next/image';
import { MainPage } from '@/pages/main-page/main-page';
import { Header, Footer } from '@/widgets';
import styles from './page.module.css';

export default function Home() {
	return (
		<>
			<Header />
			<main className={styles.main}>
				<MainPage />
			</main>
			<Footer />
		</>
	);
}
