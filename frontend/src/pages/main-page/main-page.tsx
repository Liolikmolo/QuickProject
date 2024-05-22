import style from './main-page.module.scss';
import Image from 'next/image';
import InviteLogo from '@/shared/icons/logo-hello.svg';
import { dataForMainPage } from '@/shared/temporary-const/temp-const';

export const MainPage = () => {
	const projName = dataForMainPage.projName,
		projDescr = dataForMainPage.projDescr,
		projNeed = dataForMainPage.projNeed,
		projRole = dataForMainPage.projRole;

	const ProjectCard = () => {
		return (
			<div className={style.proj_container}>
				<div className={style.proj_container_title}>{projName}</div>
				<div className={style.proj_container_descr}>{projDescr}</div>
				<div className={style.proj_container_need}>{projNeed}</div>
				<div className={style.proj_container_role}>
					{projRole.map((item, key) => {
						return (
							<span key={key} className={style.proj_container_role_item}>
								{item}
							</span>
						);
					})}
				</div>
			</div>
		);
	};

	return (
		<>
			<div className={style.invite}>
				<div className={style.purpose}>
					<h2>Мы создали эту биржу с одной целью</h2>
					<p>
						— объединить талантливых специалистов и страстных энтузиастов в
						увлекательном мире пэт-проектов. Здесь вы найдёте идеи и вызовы,
						которые помогут вам развиваться, обучаться и делиться своими
						уникальными навыками.
					</p>
					<p>
						Не важно, являетесь ли вы разработчиком, дизайнером или кем‑то, кто
						просто ищет вдохновение, наша биржа открыта для всех. Здесь вы
						можете присоединиться к увлекательным проектам, внести свой вклад и
						обрести опыт, который выходит за пределы стандартных рамок.
					</p>
				</div>
				<Image
					className={style.invite_img}
					src={InviteLogo}
					width={1029}
					height={604}
					alt='invite'
				/>
			</div>
			<div className={style.proj_list}>
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
				<ProjectCard />
			</div>
		</>
	);
};
