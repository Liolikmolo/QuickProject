import React from 'react';
import styles from './footer.module.scss';
import Logo from '@/shared/icons/logo.svg';
import Image from 'next/image';

export const Footer = () => {
	return (
		<footer className={styles.footer}>
			<Image src={Logo} alt='logo' width={92} height={46} />
		</footer>
	);
};
