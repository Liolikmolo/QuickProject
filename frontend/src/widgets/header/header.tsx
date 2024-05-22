import React from 'react';
import Image from 'next/image';
import { Button } from '@/shared/ui/button/button';
import Logo from '@/shared/icons/logo.svg';
import styles from './header.module.scss';

export const Header = () => {
	return (
		<header className={styles.header}>
			<Image src={Logo} width={146} height={73} alt='logo' />
			<Button style='primary'>Войти</Button>
		</header>
	);
};
